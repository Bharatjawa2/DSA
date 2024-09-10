class HelloWorld {
    public static void main(String[] args) {
        String sent = "hello world ok,!byee";
        String search = "ok";
        String[] arr = sent.split(" ");
        boolean found = false; 
        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replaceAll("[^a-zA-Z]", "");
            if(arr[i].equals(search)) {
                System.out.println("Found");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Not Found");
        }
    }
}
