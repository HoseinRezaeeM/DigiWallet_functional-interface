package digipay.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("unused")
@AllArgsConstructor
@Getter
@Setter

public class Wallet {
    private String id;

    @Override
    public String toString() {
        return "ID =" + id ;
    }
}
