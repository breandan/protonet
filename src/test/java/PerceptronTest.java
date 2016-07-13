import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class PerceptronTest {

  Random random = new Random();

  /**
   * Fix the inputs, vary the weights.
   */

  @Test
  public void testOutputSumOfWeights() {
    for (int j = 0; j < 100; j++) {
      double currentSum = 0;
      Map<Neuron, Connection> weights = new HashMap<>();

      for (int i = 0; i < random.nextInt(100); i++) {
        Neuron perceptron = mock(Perceptron.class);
        when(perceptron.getActivation()).thenReturn(1D);

        double weight = random.nextDouble();
        Connection connection = new Connection(perceptron, weight, 0);
        weights.put(perceptron, connection);
        currentSum += weight;
      }

      Perceptron perceptron = new Perceptron(weights);
      assertEquals(currentSum, perceptron.getActivation(), 1e-6);
    }
  }

  /**
   * Fix the weights, vary the inputs.
   */

  @Test
  public void testOutputSumOfInputs() throws Exception {
    for (int j = 0; j <100; j++) {
      double sum = 0;
      Map<Neuron, Connection> weights = new HashMap<>();

      for (int i = 0; i < random.nextInt(100); i++) {
        Neuron perceptron = mock(Perceptron.class);

        double output = random.nextDouble();
        when(perceptron.getActivation()).thenReturn(output);

        Connection connection = new Connection(perceptron, 1, 0);

        weights.put(perceptron, connection);
        sum += output;
      }

      Perceptron perceptron = new Perceptron(weights);
      assertEquals(sum, perceptron.getActivation(), 1e-6);
    }
  }
}