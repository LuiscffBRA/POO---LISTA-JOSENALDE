// Classe abstrata C1
abstract class C1 {
    protected String atributoC1;

    public C1(String atributoC1) {
        this.atributoC1 = atributoC1;
    }

    public abstract void metodoAbstratoC1();

    public void metodoComumC1() {
        System.out.println("Método comum da classe C1: " + atributoC1);
    }
}

// Classe concreta C2 herdando de C1
class C2 extends C1 {
    private int atributoC2;

    public C2(String atributoC1, int atributoC2) {
        super(atributoC1);
        this.atributoC2 = atributoC2;
    }

    // Sobrecarga de construtores
    public C2(String atributoC1) {
        this(atributoC1, 0);
    }

    @Override
    public void metodoAbstratoC1() {
        System.out.println("Método implementado em C2");
    }

    public void metodoC2() {
        System.out.println("Método exclusivo da classe C2: " + atributoC2);
    }
}

// Classe concreta C3 herdando de C1 e implementando I1 e I2
class C3 extends C1 implements I1, I2 {
    private double atributoC3;

    public C3(String atributoC1, double atributoC3) {
        super(atributoC1);
        this.atributoC3 = atributoC3;
    }

    @Override
    public void metodoAbstratoC1() {
        System.out.println("Método implementado em C3");
    }

    @Override
    public void metodoI1() {
        System.out.println("Método I1 implementado em C3");
    }

    @Override
    public void metodoI2a() {
        System.out.println("Método I2a implementado em C3");
    }

    @Override
    public void metodoI2b() {
        System.out.println("Método I2b implementado em C3");
    }

    public void metodoC3() {
        System.out.println("Método exclusivo da classe C3: " + atributoC3);
    }
}

// Classe concreta C4 herdando de C2
class C4 extends C2 {
    private boolean atributoC4;

    public C4(String atributoC1, int atributoC2, boolean atributoC4) {
        super(atributoC1, atributoC2);
        this.atributoC4 = atributoC4;
    }

    @Override
    public void metodoC2() {
        System.out.println("Método C2 sobreposto em C4: " + atributoC4);
    }
}

// Classe concreta C5 herdando de C2 e implementando I1
class C5 extends C2 implements I1 {
    private String atributoC5;

    public C5(String atributoC1, int atributoC2, String atributoC5) {
        super(atributoC1, atributoC2);
        this.atributoC5 = atributoC5;
    }

    @Override
    public void metodoI1() {
        System.out.println("Método I1 implementado em C5: " + atributoC5);
    }

    // Sobrecarga de métodos
    public void metodoC5() {
        System.out.println("Método exclusivo da classe C5");
    }

    public void metodoC5(String mensagem) {
        System.out.println("Método sobrecarregado em C5: " + mensagem);
    }
}

// Interface I1
interface I1 {
    void metodoI1();
}

// Interface I2
interface I2 {
    void metodoI2a();
    void metodoI2b();
}

// Classe principal para teste
public class Principal {
    public static void main(String[] args) {
        C2 objC2 = new C2("Atributo C1 para C2", 42);
        C3 objC3 = new C3("Atributo C1 para C3", 3.14);
        C4 objC4 = new C4("Atributo C1 para C4", 10, true);
        C5 objC5 = new C5("Atributo C1 para C5", 20, "Atributo C5");

        System.out.println("Teste da classe C2:");
        objC2.metodoComumC1();
        objC2.metodoC2();

        System.out.println("\nTeste da classe C3:");
        objC3.metodoComumC1();
        objC3.metodoC3();
        objC3.metodoI1();
        objC3.metodoI2a();
        objC3.metodoI2b();

        System.out.println("\nTeste da classe C4:");
        objC4.metodoComumC1();
        objC4.metodoC2();

        System.out.println("\nTeste da classe C5:");
        objC5.metodoComumC1();
        objC5.metodoC5();
        objC5.metodoC5("Mensagem de teste");
        objC5.metodoI1();
    }
}
