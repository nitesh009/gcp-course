package org.example;

import com.google.cloud.compute.v1.InstancesClient;
import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.ListInstancesRequest;

// List VM Instances
public class ComputeEngineDemo {

    public static void listInstances(String projectId, String zone) throws Exception {
        try (InstancesClient instancesClient = InstancesClient.create()) {
            ListInstancesRequest request = ListInstancesRequest.newBuilder()
                    .setProject(projectId)
                    .setZone(zone)
                    .build();

            for (Instance instance : instancesClient.list(request).iterateAll()) {
                System.out.printf("Instance Name: %s%n", instance.getName());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String projectId = "projectId";
        String zone = "zoneName";
        listInstances(projectId, zone);
    }
}
