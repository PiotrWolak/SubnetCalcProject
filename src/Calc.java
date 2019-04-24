import java.net.InetAddress;

public class Calc implements IPrint{
    private String ip, mask;

    public boolean retrieveIp(String input) throws Exception {
        if (input.isEmpty()){
            InetAddress a=InetAddress.getLocalHost();
            ip = a.getHostAddress();
        }


        //checking amount of dots to determine whether it is vaild ip
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.') count++;
        }
        if (count != 6) throw new Exception("za malo kropek w adresie ip");



        int slash = input.indexOf("/");
        this.ip = input.substring(0, slash);
        System.out.println(ip);
        this.mask = input.substring(slash + 1);
        System.out.println(mask);
        return true;
    }

    public boolean maskToByte(String mask){
        String byteMask = "";
        int temp;
        for(int i=0; i<4; i++){
            int j=3;
            Integer dot = mask.indexOf('.');
            temp = Integer.parseInt(mask.substring(i,j));
            byteMask+= Integer.toBinaryString(temp);
            byteMask+= '.';
            i+=4;
            j+=4;
        }
        System.out.println("~~~~~~~~~~~~");
        System.out.println(byteMask);
        return true;
    }
    public static void main(String[] args) {
        Calc kalkulatorek = new Calc();
        try {
            kalkulatorek.retrieveIp("37.47.97.150/255.255.255.0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        kalkulatorek.print();
        kalkulatorek.maskToByte("123.456.789.0");
    }

    @Override
    public void print() {
        System.out.println("my ip is : " + this.ip + " my mask is " + this.mask);
    }
}
