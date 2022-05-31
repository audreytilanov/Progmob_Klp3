package com.example.quizappfix;

class ModelPahlawan {
    String pahlawanEnsiklopedia;
    String detailPahlawan;
    int image;

    public ModelPahlawan(String pahlawanEnsiklopedia, int image, String detailPahlawan) {
        this.pahlawanEnsiklopedia = pahlawanEnsiklopedia;
        this.image = image;
        this.detailPahlawan = detailPahlawan;
    }

    public String getPahlawanEnsiklopedia() {
        return pahlawanEnsiklopedia;
    }

    public int getImage() {
        return image;
    }

    public String getDetailPahlawan() {
        return detailPahlawan;
    }
}
