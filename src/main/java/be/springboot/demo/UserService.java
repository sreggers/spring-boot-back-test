package be.springboot.demo;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    public void save(User user) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("users").document(user.getName());
        ApiFuture<WriteResult> future = docRef.set(user);
        System.out.println("Update time : " + future.get().getUpdateTime());
    }

    public List<User> findAll() throws ExecutionException, InterruptedException {

        List<User> userList = new ArrayList<>();

        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection("users").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            userList.add(document.toObject(User.class));
        }

        return userList;
    }

}
