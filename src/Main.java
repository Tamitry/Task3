/**
 * @author Тарликовский Дмитрий
 */
//Уже засыпаю. Что смог подправить - подправил. Потом ещё.
public class Main {

    public static void main(String[] args) {
        //headsandTails();

        //maxNumeral();

        //isPalindrome();   //Определяет, является ли число палиндромом. Ввод число, вывод в консоль и возвращает
                            //boolean.
        //isPrimeNumberConsole();   //Два варианта программы.
                                    // Эта выводит в консоль, является ли введеное число n простым.
        //primeDividers();  //Выводит все простые делители числа n.
        //searchofLCSandGCD();  //Ищет и выводит НОК и НОД двух чисел a и b.
        //numeralCount();   //Выводит количество различных цифр в числе n.
        //isPerfectNumbers(); //Определяет, совершенно ли число n.
        //amicableNumbers();    //Задается промежуток, в котором ищутся дружественные числа, от а до b.
    }
    //Метод тысячу раз подбрасывает монету. Выводит информацию о результатах. Не требует параметров.
    static void headsandTails() {
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
    //Не совсем понятное задание. Насколько я понял, требовалось доказать, что 9 наибольшая цифра.
    //Берется 0 и делиться на разряд. Как только остаток будет отличаться от числителя, значит число уже двуразрядное.
    static void maxNumeral() {
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

    //Определяет, является ли число палиндромом. Ввод число, вывод в консоль и возвращает
    //boolean.
    static boolean isPalindrome(int number) {
        int temp=number;
        int length=0;
        int i=0;
        int digitNumber=1;

        while (temp!=0){//количество разрядов, чтобы можно было отделять цифры
            temp/=10;
            length++;
            digitNumber*=10;
        }

        digitNumber/=10;

        while (i<length/2){

            if(number/digitNumber!=number%10){
                System.out.println("Не верно.");
                return false;
            }

            number%=digitNumber;
            digitNumber/=100;//забираем спереди и сзади
            number/=10;
            i++;

        }
        System.out.println("Верно.");
        return true;
    }

    // Эта выводит в консоль, является ли введеное число number простым.
    static boolean isPrimeNumberBoolean(int number) {

        for(int i=2;i<=Math.sqrt(number);i++) {
            if(number%i == 0) {
                return false;
            }
        }

        return true;
    }

    //Выводит все простые делители числа number.
    static void isPrimeNumberConsole(int number) {
        if(isPrimeNumberBoolean(number)) {
            System.out.println("Простое.");
        }
        else {
            System.out.println("Не простое.");
        }
    }

    //Выводит все простые делители числа number.
    static void primeDividers(int number) {

        if(number <=3) {
            System.out.println("Введите больше 3, так как 2 и 3 простые числа.");
            return;
        }

        if(isPrimeNumberBoolean(number)) {
            System.out.println("Число простое.");
            return;
        }

        String line = "";
        for(int i = 2; i<= number /2; i++) {
            if(number %i==0) {
                if (isPrimeNumberBoolean(i)) {
                    line = line  + i + ", ";
                }
            }
        }

        System.out.println(line);
    }

    //Ищет и выводит НОК и НОД двух чисел number1 и number2.
    static void searchofLCSandGCD(int number1, int number2) {
        int cm = number1 *number2; //CM - common multiple

        while (number1 !=0 && number2!=0) {
            if(number1 >number2) {
                number1 = number1 %number2;
            }
            else {
                number2 = number2% number1;
            }
        }

        System.out.println("НОД: "+(number1 +number2));
        System.out.println("НОК:"+(cm/(number1 +number2)));
    }

    //Выводит количество различных цифр в числе number.
    static void numeralCount(int number) {

        for (int i = 0; i<=9;i++) {
            int temp = number;
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

    //Определяет, совершенно ли число number.
    static boolean isPerfectNumbers(int number) {
        int temp = 0;

        for(int i=1;i<=number/2;i++) {
            if(number%i==0) {
                temp+=i;
            }
        }
        if(temp==number) {
            System.out.println("Число совершенное.");
            return true;
        }
        else {
            System.out.println("Несовершенное.");
            return false;
        }
    }

    //Задается промежуток, в котором ищутся дружественные числа, от а до rightBorder.
    static void amicableNumbers(int leftBorder, int rightBorder) {
        for(int i = leftBorder; i<rightBorder; i++) {
            for (int j=i+1;j<=rightBorder;j++) {

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
    }//Долгий и кривой способ "В ЛОБ". 2 пары за 3 минуты
                                            // 13 минут для чисел от 1 до 10000.
                                            //Более оптимизированного варианта придумать не смог

    /*static void Task341(int a, int b) {
        for(int i=a;i<=b;i++){
            int p = 3*(int)Math.pow(2,(double)i-1)-1;
            int q = 3*(int)Math.pow(2,(double)i)-1;
            int r = 9*(int)Math.pow(2,2*i-1)-1;
            if(isPrimeNumberBoolean(p)&&isPrimeNumberBoolean(q)&&isPrimeNumberBoolean(r)) {
                System.out.println("Дружественные числа "+(int)Math.pow(2,i)*p*q+" и "+(int)Math.pow(2,i)*r);
            }
        }
    }*/
}
