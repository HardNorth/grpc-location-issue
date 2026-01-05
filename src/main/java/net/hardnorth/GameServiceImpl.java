package net.hardnorth;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import net.hardnorth.protocol.GameService;
import net.hardnorth.protocol.HelloRequest;
import net.hardnorth.protocol.HelloResponse;

@GrpcService
public class GameServiceImpl implements GameService {
	@Override
	public Uni<HelloResponse> hello(HelloRequest request) {
		return Uni.createFrom().item(HelloResponse.newBuilder().setMessage("Hello from gRPC service!").build());
	}
}
