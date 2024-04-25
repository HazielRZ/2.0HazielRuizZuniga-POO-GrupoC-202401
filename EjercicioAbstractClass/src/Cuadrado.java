public class Cuadrado extends Figura {
    double lado;

    Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    double area() {
        return lado * lado;
    }

    @Override
    double perimetro() {
        return 4 * lado;
    }
}

