package io.management.Topic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
//This is a business service
//Spring MVC creates one copy of this service and stores it in memory (Singleton)

//This is typically used to store data since only one instance of this copy is used

//If this was made in controller, a new List would be made each HTTP request
@Service
public class TopicService {
    private List<Topic> dataService = Arrays.asList(
            new Topic("1", "Richard"),
            new Topic("2", "Vincent"),
            new Topic("3", "Bob")
    );

    //return new Topic("192312", "Richard"); //Returns a JSON object {"id":"192312","name":"Richard"}

    public Topic getTopic(String id){
        /*

        for(int i = 0;i<dataService.size();i++){
            if(dataService.get(i).getId().equals(id)){
                return dataService.get(i);
            };
        }

        */

        //Turns dataService into a stream; grab an array of filter object; Grab first one
        return dataService.stream().filter(currentObject -> currentObject.getId().equals(id)).findFirst().get();
    }
    public List<Topic> getAllTopics(){
        return dataService;
    }
}