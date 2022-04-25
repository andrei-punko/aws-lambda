package by.andd3dfx.lambda;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LambdaRequestStreamHandlerTest {

    private final String TEST_STRING = "SOME TEST STRING";
    private LambdaRequestStreamHandler handler;

    @Mock
    Context context;
    @Mock
    LambdaLogger lambdaLogger;

    @BeforeEach
    void setUp() {
        handler = new LambdaRequestStreamHandler();
    }

    @Test
    void handleRequest() throws IOException {
        when(context.getLogger()).thenReturn(lambdaLogger);
        InputStream inputStream = new ByteArrayInputStream(TEST_STRING.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        handler.handleRequest(inputStream, outputStream, context);

        verify(lambdaLogger).log("Input: " + TEST_STRING);
        assertThat(outputStream.toString()).isEqualTo("Hello World - " + TEST_STRING);
    }
}