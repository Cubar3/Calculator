enum RomainNumber {
    I(1), V(5), X(10), L(50),
    C(100), D(500), M(1000);
    int arabicNumber;

    RomainNumber(int arabicNumber) {
        this.arabicNumber = arabicNumber;
    }

    int getArabicNumber() {
        return arabicNumber;
    }
}
