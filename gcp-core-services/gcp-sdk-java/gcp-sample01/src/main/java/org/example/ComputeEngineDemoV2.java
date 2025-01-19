package org.example;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.compute.v1.InstancesClient;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.StartInstanceRequest;

// Start a VM Instance
public class ComputeEngineDemoV2 {

    public static void startInstance(String projectId, String zone, String instanceName) throws Exception {
        try (InstancesClient instancesClient = InstancesClient.create()) {
            StartInstanceRequest request = StartInstanceRequest.newBuilder()
                    .setProject(projectId)
                    .setZone(zone)
                    .setInstance(instanceName)
                    .build();

            OperationFuture<Operation, Operation> response = instancesClient.startAsync(request);
            System.out.printf("Starting instance: %s%n", instanceName);
            System.out.println("Operation Status: " + response.get().getStatus());
        }
    }

    public static void main(String[] args) throws Exception {
        String projectId = "projectId";
        String zone = "zoneName";
        String instanceName = "instanceName";
        startInstance(projectId, zone, instanceName);
    }
}
