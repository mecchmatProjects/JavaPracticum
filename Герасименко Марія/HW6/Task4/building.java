public class building extends building1{
    public static void main(String[] args) {
        building1 b = new building1() {
            @Override
            public String getInfo() {
                return super.getInfo();
            }
        };

        System.out.println(b.getInfo());
    }

}

abstract class building1{
        String str = "This is public Theater";
        public String getInfo(){
            return str;
        }
}
