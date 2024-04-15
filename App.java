package metodosDeOrdenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * App
 */
public class App {
    public static void main(String[] args) {
        Acomodacao[] acomodacoes = lerAcomodacoes();

        Scanner scanner = new Scanner(System.in);
        String id;
       int limite= scanner.nextInt();
       Acomodacao[] acomodacoesSelecionadas = new Acomodacao[limite];
        while (!(id = scanner.nextLine()).equals("FIM")) {
            int idBusca = Integer.parseInt(id);
            int i = 0;
            for (Acomodacao a : acomodacoes) {
                if (a.getRoomId() == idBusca) {
                    acomodacoesSelecionadas[i] = a.clone();
                    i++;
                    break;
                }
            }
        }
        //ADICIONAR AQUI A IMPLEMENTACAO DO MAIN DAS ORDENACOES

    }

    
    public static Acomodacao[] lerAcomodacoes() {
    // String caminhoArquivo = "/tmp/dados_airbnb.txt";
      String caminhoArquivo = "dados_airbnb.txt";
        String linha;
        int contador = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            br.readLine(); // Descartando primeira linha
            while (br.readLine() != null) {
                contador++;
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        Acomodacao[] acomodacoes = new Acomodacao[contador];
        contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            br.readLine(); // Descartando primeira linha
            while ((linha = br.readLine()) != null) {
                Acomodacao acomodacao = new Acomodacao();
                acomodacao.ler(linha);
                acomodacoes[contador] = acomodacao;
                contador++;
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return acomodacoes;
    }
    
    
}

//bubblesort
 class bubblesort {
    public Acomodacao[] ordenaroverallSatisfaction(Acomodacao[] acomodacoes) {
        for (int i = 0; i < acomodacoes.length; i++) {
            for (int j = 0; j < acomodacoes.length - 1; j++) {
                if (acomodacoes[j].getOverallSatisfaction() > acomodacoes[j + 1].getOverallSatisfaction()) {
                    Acomodacao temp = acomodacoes[j];
                    acomodacoes[j] = acomodacoes[j + 1];
                    acomodacoes[j + 1] = temp;
                }
            }
        }
        return acomodacoes;
    }
    
}
//insertion
 class insertion {

 }
//selection
class selection {

}
//heapsort
class heapsort {

}

//mergesort
class mergesort {

}

//quicksort
class quicksort {

}


/**
 * Acomodacao Airbnb
 */
class Acomodacao {

    private int roomId;
    private int hostId;
    private String roomType;
    private String country;
    private String city;
    private String neighborhood;
    private int reviews;
    private double overallSatisfaction;
    private int accommodates;
    private double bedrooms;
    private double price;
    private String propertyType;

    public Acomodacao(int roomId, int hostId, String roomType, String country, String city, String neighborhood, int reviews, double overallSatisfaction, int accommodates, double bedrooms, double price, String propertyType) {
        this.roomId = roomId;
        this.hostId = hostId;
        this.roomType = roomType;
        this.country = country;
        this.city = city;
        this.neighborhood = neighborhood;
        this.reviews = reviews;
        this.overallSatisfaction = overallSatisfaction;
        this.accommodates = accommodates;
        this.bedrooms = bedrooms;
        this.price = price;
        this.propertyType = propertyType;
    }
    public Acomodacao(){

    }
    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    public int getHostId() {
        return hostId;
    }
    public void setHostId(int hostId) {
        this.hostId = hostId;
    }
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getNeighborhood() {
        return neighborhood;
    }
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    public int getReviews() {
        return reviews;
    }
    public void setReviews(int reviews) {
        this.reviews = reviews;
    }
    public double getOverallSatisfaction() {
        return overallSatisfaction;
    }
    public void setOverallSatisfaction(double overallSatisfaction) {
        this.overallSatisfaction = overallSatisfaction;
    }
    public int getAccommodates() {
        return accommodates;
    }
    public void setAccommodates(int accommodates) {
        this.accommodates = accommodates;
    }
    public double getBedrooms() {
        return bedrooms;
    }
    public void setBedrooms(double bedrooms) {
        this.bedrooms = bedrooms;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getPropetyType() {
        return propertyType;
    }
    public void setPropetyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public void ler(String linha) {
        Scanner scanner = new Scanner(System.in);

        String[] dados = linha.split("\t");
         roomId = Integer.parseInt(dados[0]);
         hostId = Integer.parseInt(dados[1]);
         roomType = dados[2];
         country = dados[3];
         city = dados[4];
         neighborhood = dados[5];
         reviews = Integer.parseInt(dados[6]);
         overallSatisfaction = Double.parseDouble(dados[7]);
         accommodates = Integer.parseInt(dados[8]);
         bedrooms = Double.parseDouble(dados[9]);
         price = Double.parseDouble(dados[10]);
         propertyType = dados[11];
        
    }

    public void imprimir() {
        System.out.println("[" + roomId + " ## " + hostId + " ## " + roomType + " ## " + country + " ## " + city +
                " ## " + neighborhood + " ## " + reviews + " ## " + overallSatisfaction + " ## " + accommodates +
                " ## " + bedrooms + " ## " + price + " ## " + propertyType + "]");
    }

    public Acomodacao clone(){
        return new Acomodacao(roomId, hostId, roomType, country, city, neighborhood, reviews, overallSatisfaction, accommodates, bedrooms, price, propertyType);
    }

}
