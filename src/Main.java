import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int max=0;
    static int intrebariMax=0;

    public static void main(String[] args)
    {
        int corect=0;
        int gresit=0;
        int intrebari=0;
        double procentaj=0;
        String[] intrebariJava={"Care dintre următoarele este un tip primitiv în Java? ",
                "De la ce index începe un array în Java?",
                "Ce face System.out.println()?",
                "Ce cuvânt-cheie este folosit pentru a crea un obiect?",
                "Ce returnează 5 / 2 dacă ambele valori sunt de tip int?",
                "Ce cuvânt-cheie este folosit pentru a ieși dintr-un loop?",
                "Ce reprezintă this într-o clasă?",
                "Ce se întâmplă dacă încerci să accesezi array[10] când array-ul are doar 5 elemente?",
                "Care este diferența principală dintre == și .equals() când compari obiecte?",
                "Ce permite ArrayList față de un array obișnuit?"};

        String[][] raspunsuriJava = {
                {"1. String", "2. int", "3. Scanner", "4. ArrayList"},
                {"1. 0", "2. 1", "3. -1", "4. Depinde de array"},
                {"1. Citește de la tastatură", "2. Șterge o variabilă", "3. Afișează ceva în consolă", "4. Oprește programul"},
                {"1. object", "2. create", "3. new", "4. class"},
                {"1. 2.5", "2. 2", "3. 3", "4. 0"},
                {"1. exit", "2. stop", "3. break", "4. end"},
                {"1. Clasa părinte", "2. Obiectul curent", "3. Metoda principală", "4. Un obiect nou"},
                {"1. Returnează null", "2. Returnează 0", "3. Apare o excepție", "4. Java extinde automat array-ul"},
                {"1. Nu există nicio diferență", "2. == compară referințe, equals() poate compara conținutul", "3. == compară doar String-uri", "4. equals() compară doar numere"},
                {"1. Poate stoca doar String-uri", "2. Își poate modifica dinamic dimensiunea", "3. Nu poate avea duplicate", "4. Nu poate fi parcurs cu for"}};

        int[] raspunsuriCorecteJava = {
                1, 0, 2, 2, 1, 2, 1, 2, 1, 1
        };

        String terminat="nu";
        while(terminat.equals("nu"))
        {

        meniu();
        int alegere=scanner.nextInt();
        switch(alegere)
        {
            case 1->{
                System.out.println("Alege dificultatea:\n 1.Easy(5)\n 2.Medium(7)\n 3.Hard(10)");
                int difAles=scanner.nextInt();


                int dimensiune=dificultate(difAles);

                 corect=0;
                 gresit=0;
                 intrebari=0;
                 intrebariMax=dimensiune;
                for(int i=0;i< dimensiune;i++)
                {
                    System.out.println(intrebariJava[i]);
                    for(int j=0;j<raspunsuriJava[i].length;j++)
                    {
                        System.out.println(raspunsuriJava[i][j]);
                    }
                    System.out.println("Raspunsul tau este: ");
                    int raspuns=scanner.nextInt();
                    while(raspuns<1 || raspuns>4)
                    {
                        System.out.println("invalid, alege intre 1 2 3 si 4");
                        raspuns=scanner.nextInt();
                    }
                    if((raspuns-1)==raspunsuriCorecteJava[i])
                    {
                        System.out.println("Corect");
                        corect++;
                    }
                    else
                    {
                        System.out.println("Gresit");
                        gresit++;
                    }
                    intrebari++;
                }

                /*
                System.out.println("cele corecte " + corect);
                System.out.println("cele gresite " + gresit);

                 */

            }
            case 2-> afiseazaIntrebari(intrebariJava);

            case 3->procentaj=statistici(corect,gresit,intrebari);

            case 4->bestScore(corect,intrebari);

            case 5->{
                terminat="Da";
                System.out.println("Multumim de vizita!");
            }
        }

        }
    }

    static void meniu()
    {
        System.out.print("===== QUIZ TOURNAMENT =====\n" +
                "\n" +
                "1. Start Quiz\n" +
                "2. Afiseaza intrebarile\n" +
                "3. Statistici\n" +
                "4. Best Score\n" +
                "5. Exit\n" +
                "\n" +
                "Alege o optiune:");
    }

    static double statistici(int corect,int gresit,int intrebari)
    {
        if(intrebari==0){
            System.out.println("nu sunt statistici deocamdata");
            return 0;
        }
        else{
        System.out.println("===== STATISTICI =====");
        System.out.println("intrebari: " + intrebari);
        System.out.println("corecte: "+corect);
        System.out.println("gresite: "+gresit);
        double procentaj=(double)corect/intrebari*100;
        System.out.println("Procentaj "+procentaj+"\n\n");

        return procentaj;}
    }

    static void bestScore(int corect,int intrebari)
    {

        if((double)corect/intrebari>(double)max/intrebariMax)
        {
            max=corect;
            intrebariMax=intrebari;
        }
        System.out.println("cel mai bun scor al tau este "+ max+ " " + "/" +intrebariMax);
    }

    static void afiseazaIntrebari(String[] intrebariJava)
    {
        for(int i=0;i< intrebariJava.length;i++)
        {
            System.out.println(intrebariJava[i]);
        }
    }

    static int dificultate(int difAles)
    {
       while(difAles<1|| difAles>3)
       {
           System.out.println("Invalid, alege intre 1 2 si 3");
           difAles=scanner.nextInt();
       }

        if(difAles==1)
        {
            return 5;
        }
        else if(difAles==2)
        {
            return 7;
        }
        else
        {
            return 10;
        }


    }


}
