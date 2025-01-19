package org.example;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.compute.v1.InstancesClient;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.StopInstanceRequest;

public class ComputeEngineDemoV3 {

    public static void stopInstance(String projectId, String zone, String instanceName) throws Exception {
        try (InstancesClient instancesClient = InstancesClient.create()) {
            StopInstanceRequest request = StopInstanceRequest.newBuilder()
                    .setProject(projectId)
                    .setZone(zone)
                    .setInstance(instanceName)
                    .build();

            OperationFuture<Operation, Operation> response = instancesClient.stopAsync(request);
            System.out.printf("Stopping instance: %s%n", instanceName);
            System.out.println("Operation Status: " + response.get().getStatus());
        }
    }

    public static void main(String[] args) throws Exception {
        String projectId = "projectId";
        String zone = "zoneName";
        String instanceName = "instanceName";
        stopInstance(projectId, zone, instanceName);
    }
}
