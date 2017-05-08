package RozetkaUserProfile;

import java.util.List;

/**
 * Created by user on 08.05.17.
 */
public class User {
        public Integer auth;
        public Boolean createdAfterDoupleOptin;
        public Integer ordersAmount;
        public SuggestCities suggestCities;
        public Integer id;
        public String title;
        public String email;
        public Integer passwordStatus;
        public String login;
        public Boolean confirmed;
        public Addresses addresses;
        public Phones phones;
        public Object priceType;
        public List<Object> accounts;
        public Subscribes subscribes;

        public User(Integer auth, Boolean createdAfterDoupleOptin, Integer ordersAmount, SuggestCities suggestCities, Integer id, String title, String email, Integer passwordStatus, String login, Boolean confirmed, Addresses addresses, Phones phones, Object priceType, List<Object> accounts, Subscribes subscribes) {
                this.auth = auth;
                this.createdAfterDoupleOptin = createdAfterDoupleOptin;
                this.ordersAmount = ordersAmount;
                this.suggestCities = suggestCities;
                this.id = id;
                this.title = title;
                this.email = email;
                this.passwordStatus = passwordStatus;
                this.login = login;
                this.confirmed = confirmed;
                this.addresses = addresses;
                this.phones = phones;
                this.priceType = priceType;
                this.accounts = accounts;
                this.subscribes = subscribes;
        }
        public User(){

        }
}
