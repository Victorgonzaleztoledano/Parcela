import org.w3c.dom.css.Rect;

abstract class Figura{
    public abstract double area();
    public abstract double perimetro();
}
class Rectangulo extends Figura{
    private double base;
    private double altura;

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public Rectangulo(double base, double altura) throws Exception {
        if ( base > 0.1) this.base = base;
        else throw new Exception("La base del rectángulo debe ser superior a 0.1");
        if ( altura > 0.1) this.altura = altura;
        else throw new Exception("La altura del rectángulo debe ser superior a 0.1");
    }

    @Override
    public double area() {
        return base * altura;
    }

    @Override
    public double perimetro() {
        return (base + altura) * 2;
    }
}
class Triangulo extends Figura{
    private double base;
    private double altura;

    public Triangulo(double base, double altura) throws Exception {
        if ( base > 0.1) this.base = base;
        else throw new Exception("La base del triángulo debe ser superior a 0.1");
        if ( altura > 0.1) this.altura = altura;
        else throw new Exception("La altura del triángulo debe ser superior a 0.1");
    }
    public double hipotenusa(){
        return Math.sqrt(Math.pow(base,2) + Math.pow(altura, 2));
    }

    public double getAltura() {
        return altura;
    }

    public double getBase() {
        return base;
    }

    @Override
    public double area() {
        return (base * altura) /2;
    }

    @Override
    public double perimetro() {
        return base + altura + hipotenusa();
    }
}
class Circulo extends Figura{
    private double diametro;

    public Circulo(double diametro) throws Exception {
        if ( diametro > 0.1 ) this.diametro = diametro;
        else throw new Exception("El diametro del círculo debe ser superior a 0.1");
    }

    public double getRadio() {
        return diametro/2;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(getRadio(), 2);
    }

    @Override
    public double perimetro() {
        return circunferencia();
    }

    public double circunferencia(){
        return Math.PI * diametro;
    }
}
class Parcela extends Figura {
    private Figura figuras[];

    public Parcela(Figura[] figuras) {
        this.figuras = figuras;
    }

    @Override
    public double area() {
        double result = 0.0;
        for (Figura figura : figuras) {
            result += figura.area();
        }
        return result;
    }

    @Override
    public double perimetro() {
        double result = 0.0;
        for (Figura figura : figuras) {
            result += figura.area();
        }
        return result;
    }
    public double sacarSolapes(double perimetro) throws Exception {
        Rectangulo Rectangulo = new Rectangulo(8,4);
        Rectangulo Cuadrado = new Rectangulo(4,4);
        Triangulo Triangulo = new Triangulo(2,3);
        perimetro = perimetro() - Triangulo.getBase() - (Cuadrado.getBase()/2) - Cuadrado.getBase() -Rectangulo.getBase() - (Rectangulo.getAltura()*2);
        return perimetro;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Figura[] figuras = {new Circulo(4), new Rectangulo(8, 4), new Rectangulo(4, 4), new Triangulo(2, 6), new Triangulo(2, 3)};
            Parcela Parcela = new Parcela(figuras);
            double area = Parcela.area();
            double costeArea = 32 * area;
            System.out.println("Expropiar todo el area costaría : " + costeArea);

            double perimetro = Parcela.sacarSolapes(Parcela.perimetro());
            System.out.println("El perímetro total de la parcela es: " + perimetro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}