import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Task34(1, 10000);
    }
    static void Task31() {
        int heads = 0;//Орёл и
        int tails = 0;//решка
        int count = 1000;
        for(int i=0;i<count;i++){
            if(Math.round(Math.random())==0){
                heads++;
            }
            else {
                tails++;
            }
        }
        System.out.println("Количество выпадений орла: "+heads+", выпадений решки: "+tails);
    }
    static void Task321() {
        int n=0;
        int max = 0;
        while(n%10==n){
            if(n>max){
                max=n;
            }
            n++;
        }
        System.out.println(max);
    }
    static void Task322(int n) {
        int temp=n;
        int length=0;
        int i=0;
        int potomNazovu=1;
        while (temp!=0){
            temp/=10;
            length++;
            potomNazovu*=10;
        }
        potomNazovu/=10;
        while (i<length/2){
            if(n/potomNazovu!=n%10){
                System.out.println("Не верно.");
                return;
            }
            n%=potomNazovu;
            potomNazovu/=100;
            n/=10;
            i++;
        }
        System.out.println("Верно.");
    }
    static boolean Task323(int n) {
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }//Для проверки этого задания используйте Task324. Если введете простое число, оно
                                       //сообщит об этом, а если обычное, то покажет простые делители.
    static void Task324(int n) {
        if(n<=3) {
            System.out.println("Введите больше 3, так как 2 и 3 простые числа.");
            return;
        }
        if(Task323(n)) {
            System.out.println("Число простое.");
            return;
        }
        String line = "2";
        for(int i=3;i<=n/2;i++) {
            if(n%10==0) {
                if (Task323(i)) {
                    line = line + ", " + i;
                }
            }
        }
        System.out.println(line);
    }
    static void Task325(int a, int b) {
        int cm = a*b; //CM - common multiple
        while (a!=0 && b!=0) {
            if(a>b) {
                a = a%b;
            }
            else {
                b = b%a;
            }
        }
        System.out.println("НОД: "+(a+b));
        System.out.println("НОК:"+(cm/(a+b)));
    }
    static void Task326(int n) {
        for (int i = 0; i<=9;i++) {
            int temp = n;
            int count = 0;
            while (temp!=0) {
                int numeral = temp%10;
                temp/=10;
                if(numeral==i) {
                    count++;
                }
            }
            System.out.println("Цифра "+i+" появилась "+count+" раз.");
        }
    }
    static void Task33(int n) {
        int temp = 0;
        for(int i=1;i<=n/2;i++) {
            if(n%i==0) {
                temp+=i;
            }
        }
        if(temp==n) {
            System.out.println("Число совершенное.");
        }
        else {
            System.out.println("Несовершенное.");
        }
    }
    static void Task34(int a, int b) {
        for(int i=a;i<b;i++) {
            for (int j=i+1;j<=b;j++) {
                int temp1 = 0;
                int temp2 = 0;
                for(int k=1;k<=i/2;k++) {
                    if(i%k==0) {
                        temp1+=k;
                    }
                }
                for(int k=1;k<=j/2;k++) {
                    if(j%k==0) {
                        temp2+=k;
                    }
                }
                if(temp1==j && temp2==i) {
                    System.out.println("Дружественные числа "+temp1+" и "+temp2);
                }
            }
        }
    }//Долгий и кривой способ "В ЛОБ". 2 пары за 3 минуты))))
                                            // 13 минут для чисел от 1 до 10000. Как выяснилось, другого способа нет.
    /*static void Task341(int a, int b) {
        for(int i=a;i<=b;i++){
            int p = 3*(int)Math.pow(2,(double)i-1)-1;
            int q = 3*(int)Math.pow(2,(double)i)-1;
            int r = 9*(int)Math.pow(2,2*i-1)-1;
            if(Task323(p)&&Task323(q)&&Task323(r)) {
                System.out.println("Дружественные числа "+(int)Math.pow(2,i)*p*q+" и "+(int)Math.pow(2,i)*r);
            }
        }
    }*/
}
