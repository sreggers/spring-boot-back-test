package be.springboot.demo;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.firestore.Document;

@Data @AllArgsConstructor @NoArgsConstructor
@Document(collectionName = "users")
public class User {

    @DocumentId
    String name;

    String email;

}
