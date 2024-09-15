'use strict' // Enforces strict mode for better error checking and safer JavaScript execution

// Selecting the HTML elements used in the program
const numberbox = document.getElementById("numberbox"); // Input field to specify the size of the board
const slider = document.getElementById("slider"); // Input element to control the speed of the visualizer
const progressBar = document.getElementById("progress-bar"); // Progress bar representing slider's value
const playButton = document.getElementById('play-button'); // Button to start the visualizer
const pauseButton = document.getElementById("pause-button"); // Button to pause the visualizer (currently unused)

const queen = '<i class="fas fa-chess-queen" style="color:#000"></i>'; // Represents a queen piece using an icon

let n, speed, tempSpeed, q, Board = 0; // Declaring variables for the size of the board, speed, temp speed, instance of Queen class, and the board state counter

// Array containing the number of possible arrangements for N-Queen problem from N=0 to N=8
let array = [0, 2, 1, 1, 3, 11, 5, 41, 93];

// Object to store the state (position) of the queens on different boards
let pos = {};

// Set the initial speed of the animation based on the slider's value
speed = (100 - slider.value) * 10;
tempSpeed = speed; // Temporary storage for the speed value
slider.oninput = function () {
    progressBar.style.width = this.value + "%"; // Adjust the progress bar width as per slider value
    speed = slider.value; // Set speed based on slider
    speed = (100 - speed) * 10; // Inverting and scaling the speed value (100 is fast, 0 is slow)
}

// Queen class definition
class Queen {
    constructor() {
        this.position = Object.assign({}, pos); // Initializes queen position based on previously stored positions
        this.uuid = []; // Unique IDs for multiple boards
    }

    // Function to initiate solving the N-Queen problem
    nQueen = async () => {
        Board = 0; // Reset board counter
        this.position[`${Board}`] = {}; // Initialize position for the first board
        numberbox.disabled = true; // Disable the input box while solving
        await q.solveQueen(Board, 0, n); // Start solving for the first board (board 0) with row 0
        await q.clearColor(Board); // Clear any remaining highlights after solving
        numberbox.disabled = false; // Enable the input box after solving
    }

    // Function to check if placing a queen at a given position is valid
    isValid = async (board, r, col, n) => {
        const table = document.getElementById(`table-${this.uuid[board]}`); // Get the current board by its unique ID
        const currentRow = table.firstChild.childNodes[r]; // Get the row at index r
        const currentColumn = currentRow.getElementsByTagName("td")[col]; // Get the column at index col
        currentColumn.innerHTML = queen; // Place the queen icon in the current cell
        await q.delay(); // Wait for some time to simulate animation

        // Checking if there's another queen in the same column above the current position
        for (let i = r - 1; i >= 0; --i) {
            const row = table.firstChild.childNodes[i];
            const column = row.getElementsByTagName("td")[col];
            const value = column.innerHTML;
            if (value == queen) { // If another queen is found in the column
                column.style.backgroundColor = "#FB5607"; // Mark the conflicting cell
                currentColumn.innerHTML = "-"; // Remove the queen from the current cell
                return false; // Return false indicating an invalid position
            }
            column.style.backgroundColor = "#ffca3a"; // Highlight the cells that were checked
            await q.delay(); // Wait for animation
        }

        // Checking the upper left diagonal for conflicting queens
        for (let i = r - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            const row = table.firstChild.childNodes[i];
            const column = row.getElementsByTagName("td")[j];
            const value = column.innerHTML;
            if (value == queen) { // If another queen is found on the left diagonal
                column.style.backgroundColor = "#fb5607"; // Mark the conflicting cell
                currentColumn.innerHTML = "-"; // Remove the queen from the current cell
                return false;
            }
            column.style.backgroundColor = "#ffca3a"; // Highlight the cells that were checked
            await q.delay(); // Wait for animation
        }

        // Checking the upper right diagonal for conflicting queens
        for (let i = r - 1, j = col + 1; i >= 0 && j < n; --i, ++j) {
            const row = table.firstChild.childNodes[i];
            const column = row.getElementsByTagName("td")[j];
            const value = column.innerHTML;
            if (value == queen) { // If another queen is found on the right diagonal
                column.style.backgroundColor = "#FB5607"; // Mark the conflicting cell
                currentColumn.innerHTML = "-"; // Remove the queen from the current cell
                return false;
            }
            column.style.backgroundColor = "#ffca3a"; // Highlight the cells that were checked
            await q.delay(); // Wait for animation
        }
        return true; // If no conflict is found, return true
    }

    // Function to clear the color of the board back to its original state
    clearColor = async (board) => {
        for (let j = 0; j < n; ++j) {
            const table = document.getElementById(`table-${this.uuid[board]}`);
            const row = table.firstChild.childNodes[j];
            for (let k = 0; k < n; ++k)
                (j + k) & 1 // Alternate between two colors
                    ? (row.getElementsByTagName("td")[k].style.backgroundColor = "#FF9F1C")
                    : (row.getElementsByTagName("td")[k].style.backgroundColor = "#FCCD90");
        }
    }

    // Function to introduce a delay in the visualization (animation control)
    delay = async () => {
        await new Promise((done) => setTimeout(() => done(), speed)); // Delay based on speed value
    }

    // Recursive function to solve the N-Queen problem
    solveQueen = async (board, r, n) => {
        if (r == n) { // If all queens are placed (base case)
            ++Board; // Move to the next board
            let table = document.getElementById(`table-${this.uuid[Board]}`); // Get the next board
            for (let k = 0; k < n; ++k) {
                let row = table.firstChild.childNodes[k];
                row.getElementsByTagName("td")[this.position[board][k]].innerHTML = queen; // Place queens on the next board
            }
            this.position[Board] = this.position[board]; // Store the solution of the current board
            return;
        }

        // Try placing the queen in each column of the current row
        for (let i = 0; i < n; ++i) {
            await q.delay(); // Introduce delay for animation
            await q.clearColor(board); // Clear the color before checking
            if (await q.isValid(board, r, i, n)) { // Check if placing the queen at (r, i) is valid
                await q.delay(); // Delay for animation
                await q.clearColor(board); // Clear the color
                let table = document.getElementById(`table-${this.uuid[board]}`);
                let row = table.firstChild.childNodes[r];
                row.getElementsByTagName("td")[i].innerHTML = queen; // Place the queen

                this.position[board][r] = i; // Store the queen's position

                if (await q.solveQueen(board, r + 1, n)) // Recursively solve for the next row
                    await q.clearColor(board); // Clear the color if a solution is found

                await q.delay(); // Delay for animation
                board = Board; // Move to the next board
                table = document.getElementById(`table-${this.uuid[board]}`);
                row = table.firstChild.childNodes[r];
                row.getElementsByTagName("td")[i].innerHTML = "-"; // Remove the queen (backtracking)

                delete this.position[`${board}`][`${r}`]; // Remove the queen's position from the stored positions
            }
        }
    }
}

// Function to start the N-Queen visualizer when the play button is clicked
playButton.onclick = async function visualise() {
    const chessBoard = document.getElementById("n-queen-board"); // Get the div containing the boards
    const arrangement = document.getElementById("queen-arrangement"); // Get the div displaying the possible arrangements

    n = numberbox.value; // Get the size of the board from the input box
    q = new Queen(); // Create a new instance of the Queen class

    if (n > 8) { // Check if the board size is too large
        numberbox.value = "";
        alert("Queen value is too large");
        return;
    } else if (n < 1) { // Check if the board size is too small
        numberbox.value = "";
        alert("Queen value is too small");
        return;
    }

    // Clear previous boards and arrangements from the UI
    while (chessBoard.hasChildNodes()) {
        chessBoard.removeChild(chessBoard.firstChild);
    }
    if (arrangement.hasChildNodes()) {
        arrangement.removeChild(arrangement.lastChild);
    }

    // Display the number of possible arrangements for the given board size
    const para = document.createElement("p");
    para.setAttribute("class", "queen-info");
    para.innerHTML = `For ${n}x${n} board, ${array[n] - 1} arrangements are possible.`;
    arrangement.appendChild(para);

    // Add boards to the UI
    if (chessBoard.childElementCount === 0) {
        for (let i = 0; i < array[n]; ++i) {
            q.uuid.push(Math.random()); // Generate a unique ID for each board
            let div = document.createElement('div');
            let table = document.createElement('table');
            let header = document.createElement('h4');
            header.innerHTML = `Board ${i + 1} `; // Add header for each board
            table.setAttribute("id", `table-${q.uuid[i]}`); // Set ID for each board's table
            header.setAttribute("id", `paragraph-${i}`);
            chessBoard.appendChild(div); // Append the new board to the chessBoard div
            div.appendChild(header); // Append the header
            div.appendChild(table); // Append the table
        }
    }

    // Set up the table (board) for each possible arrangement
    for (let k = 0; k < array[n]; ++k) {
        let table = document.getElementById(`table-${q.uuid[k]}`);
        for (let i = 0; i < n; ++i) {
            const row = table.insertRow(i); // Create a new row
            row.setAttribute("id", `Row${i} `);
            for (let j = 0; j < n; ++j) {
                const col = row.insertCell(j); // Create a new column
                (i + j) & 1 // Set alternating colors for the board
                    ? (col.style.backgroundColor = "#FF9F1C")
                    : (col.style.backgroundColor = "#FCCD90");
                col.innerHTML = "-"; // Set initial cell value as empty
                col.style.border = "0.3px solid #373f51"; // Set border for the cells
            }
        }
        await q.clearColor(k); // Clear color for each board after setting it up
    }
    await q.nQueen(); // Start solving the N-Queen problem
};
