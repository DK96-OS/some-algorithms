package io.github.dk96os.algorithms;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

/** Provides all algorithms as a stream of arguments
 * @author DK96-OS : 2022
 */
public final class AlgorithmArgumentsProvider
	implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(
		ExtensionContext context
	) throws Exception {
		return Stream.of(
			new InitialAlgorithm(),
			new IndexTraversalEnhancedAlgorithm()
		).map(Arguments::of);
	}

}