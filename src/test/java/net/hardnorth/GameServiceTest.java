package net.hardnorth;

import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import net.hardnorth.protocol.GameService;
import net.hardnorth.protocol.HelloRequest;
import net.hardnorth.protocol.HelloResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class GameServiceTest {

	@GrpcClient("game-service")
	GameService gameService;

	@Test
	void testHello() {
		HelloRequest request = HelloRequest.newBuilder().build();
		HelloResponse response = gameService.hello(request).await().indefinitely();

		assertNotNull(response);
		assertEquals("Hello from gRPC service!", response.getMessage());
	}
}
