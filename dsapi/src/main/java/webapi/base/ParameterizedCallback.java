package webapi.base;

/**
 * The Callback is designed to provide a common, reusable interface that accepts an argument from type {@param <T>}
 * and produces a result from type {@param <S>}.
 *
 * @param <T> Input type
 * @param <S> Output type
 */
public interface ParameterizedCallback<T, S> {

    S call(T response);

}
