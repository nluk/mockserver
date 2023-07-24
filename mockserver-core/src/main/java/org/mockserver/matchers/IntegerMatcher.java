package org.mockserver.matchers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.mockserver.logging.MockServerLogger;
import org.mockserver.model.ObjectWithReflectiveEqualsHashCodeToString;

/**
 * @author jamesdbloom
 */
public class IntegerMatcher extends ObjectWithReflectiveEqualsHashCodeToString implements Matcher<Integer> {
    private static final String[] excludedFields = {"mockServerLogger"};
    private final MockServerLogger mockServerLogger;
    private final Integer matcher;

    IntegerMatcher(MockServerLogger mockServerLogger, Integer matcher) {
        this.mockServerLogger = mockServerLogger;
        this.matcher = matcher;
    }

    @Override
    public boolean matches(final MatchDifference context, Integer matched) {
        boolean result = false;

        if (matcher == null) {
            result = true;
        } else if (matched != null) {
            result = matched.equals(matcher);
        }

        if (!result && context != null) {
            context.addDifference(mockServerLogger, "integer match failed expected:{}found:{}", this.matcher, matched);
        }

        return result;
    }

    public boolean isBlank() {
        return matcher == null;
    }

    @Override
    @JsonIgnore
    public String[] fieldsExcludedFromEqualsAndHashCode() {
        return excludedFields;
    }

}
