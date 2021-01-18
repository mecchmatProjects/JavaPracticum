package Task17;

import java.util.ArrayList;
import java.util.Collections;
// task 1.7(OOP) Fedchenko Yaroslav Phone: id, Прізвище, Ім'я, По батькові, Адреса, Номер кредитної картки, Дебет, Кредит, Час міських імеждугородних разговоров.
// Створити масив об'єктів. Вивести:
// a) відомості обабонентах, укоторих час внутрішньоміських розмов перевищує ліміт;
// b) відомості обабонентах, які користувалися міжміським зв'язком;
// c) відомості обабонентах валфавітном порядку.
public class Main{
    public static class Phone{
        int id;
        String lastName, firstName;
        String address, cardNumber;
        int debit, credit;
        int localMinutes, globalMinutes;

        public Phone(){
            this.id = 0;
            lastName = "";
            firstName = "";
            address = "";
            cardNumber = "";
            debit = 0;
            credit = 0;
            localMinutes = 0;
            globalMinutes = 0;
        }

        public Phone(int id, String lastName, String firstName,
                     String address, String cardNumber,
                     int debit, int credit,
                     int localMinutes, int globalMinutes){
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.address = address;
            this.cardNumber = cardNumber;
            this.debit = debit;
            this.credit = credit;
            this.localMinutes = localMinutes;
            this.globalMinutes = globalMinutes;
        }

        public void setId(int id) { this.id = id; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }
        public void setAddress(String address) { this.address = address; }
        public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
        public void setDebit(int debit) { this.debit = debit; }
        public void setCredit(int credit) { this.credit = credit; }
        public void setLocalMinutes(int localMinutes) { this.localMinutes = localMinutes; }
        public void setGlobalMinutes(int globalMinutes) { this.globalMinutes = globalMinutes; }

        public int getId() { return id; }
        public String getLastName() { return lastName; }
        public String getFirstName() { return firstName; }
        public String getAddress() { return address; }
        public String getCardNumber() { return cardNumber; }
        public int getDebit() { return debit; }
        public int getCredit() { return credit; }
        public int getLocalMinutes() { return localMinutes; }
        public int getGlobalMinutes() { return globalMinutes; }

        @Override
        public String toString() {
            String info = "";
            info += lastName + " " + firstName + ", card number: " + cardNumber;

            return info;
        }
    }

    public static void main(String[] args) {
        Phone phone1 = new Phone(1, "name1", "first1", "sada", "12345", 1000, 500, 300, 600);
        Phone phone2 = new Phone(2, "name2", "first2", "fjdj", "678", 600, 100, 0, 750);
        Phone phone3 = new Phone(3, "name3", "first3", "ADRS3", "380933333333", 5, 5, 18, 50);

        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(phone1);
        phones.add(phone2);
        phones.add(phone3);

        // task a
        System.out.println("Час розмов перевищує ліміт");
        for (Phone phone: phones) {
            if (phone.getLocalMinutes() > (phone.getDebit() + phone.getCredit())){
                System.out.println(phone.getFirstName());
            }
        }

        // task b
        System.out.println("Користувалися міжміськім зв'язком");
        for (Phone phone: phones) {
            if (phone.getLocalMinutes() > 0){
                System.out.println(phone.getFirstName());
            }
        }

        // task c
        System.out.println("абоненти в алфавітному порядку");
        ArrayList<String> arr = new ArrayList<String>();
        for (int i = 0; i < phones.size(); i++){
            arr.add(phones.get(i).toString());
        }

        Collections.sort(arr);

        for (String phone: arr){
            System.out.println(phone);
        }
    }
}