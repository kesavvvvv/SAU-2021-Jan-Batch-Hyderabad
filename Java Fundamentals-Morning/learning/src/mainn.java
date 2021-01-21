public class mainn {

        public static void main(String args[])
        {

            Singleton x = Singleton.getInstance();
            Singleton y = Singleton.getInstance();

            System.out.println("Original");
            System.out.println("X: " + x.num);
            System.out.println("Y: " + y.num);

            x.num = 44;
            System.out.println("Changing X");
            System.out.println("X: " + x.num);
            System.out.println("Y: " + y.num);

            y.num = 44;
            System.out.println("Changing Y");
            System.out.println("X: " + x.num);
            System.out.println("Y: " + y.num);

        }

}
