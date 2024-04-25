class Triangulo extends Figura {
    double base;
    double altura;

    Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    double area() {
        return 0.5 * base * altura;
    }

    @Override
    double perimetro() {

        return base * 3;
    }
}

