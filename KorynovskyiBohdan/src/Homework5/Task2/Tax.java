package Homework5.Task2;

enum TypeOfTax {
    MainWork,
    SecondWork,
    CopyrightAwards,
    SaleOfProperty,
    Gift,
    TransfersFromAbroad,
    Exemption,
}

class Tax {
    TypeOfTax type;
    double value;
    double percentage;

    Tax(){}

    Tax(TypeOfTax type, double value, double percentage) {
        this.type = type;
        this.value = value;
        this.percentage = percentage;
    }

    public double getTax() {
        return value * percentage;
    }

    @Override
    public String toString(){
        return switch (type) {
            case MainWork -> "MainWork";
            case SecondWork -> "SecondWork";
            case CopyrightAwards -> "CopyrightAwards";
            case SaleOfProperty -> "SaleOfProperty";
            case Gift -> "Gift";
            case TransfersFromAbroad -> "TransfersFromAbroad";
            case Exemption -> "Exemption";
        };
    }
}