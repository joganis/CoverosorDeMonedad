import com.google.gson.annotations.SerializedName;

public record Rates(
        @SerializedName("conversion_rates")
       Moneda conversionRates
) {

}
