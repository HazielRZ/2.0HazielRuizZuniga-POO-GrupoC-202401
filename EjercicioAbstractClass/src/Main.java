public class Main {
    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo(5, 3);
        Cuadrado cuadrado = new Cuadrado(4);
        Rectangulo rectangulo = new Rectangulo(6, 3);
        Circulo circulo = new Circulo(2.5);

        System.out.println("Triángulo equilatero:");
        System.out.println("Área: " + triangulo.area());
        System.out.println("Perímetro: " + triangulo.perimetro());

        System.out.println("\nCuadrado:");
        System.out.println("Área: " + cuadrado.area());
        System.out.println("Perímetro: " + cuadrado.perimetro());

        System.out.println("\nRectangulo:");
        System.out.println("Área: " + rectangulo.area());
        System.out.println("Perímetro: " + rectangulo.perimetro());

        System.out.println("\nCírculo:");
        System.out.println("Área: " + circulo.area());
        System.out.println("Perímetro: " + circulo.perimetro());
    }
}