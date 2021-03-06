package com.gildedrose;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

public class RulesTest {

    @Test
    public void defaultRuleForStandardItem() {
        Rules rules = new Rules();
        List<AgeingRule> allRules = rules.getAll();
        assertThat(allRules.get(0), instanceOf(StandardRule.class));
    }

    @Test
    public void standardRuleIsAfterCustomRules() {
        Rules rules = new Rules(new AgedBrieRule());
        List<AgeingRule> allRules = rules.getAll();

        assertThat(allRules.size(), Matchers.is(2));
        assertThat(allRules.get(0), instanceOf(AgedBrieRule.class));
        assertThat(allRules.get(1), instanceOf(StandardRule.class));
    }

    @Test
    public void duplicateRuleAdded() {
        Rules rules = new Rules(new AgedBrieRule(), new AgedBrieRule());
        List<AgeingRule> allRules = rules.getAll();

        assertThat(allRules.size(), Matchers.is(3));
        assertThat(allRules.get(2), instanceOf(StandardRule.class));
        assertThat(allRules.get(1), instanceOf(AgedBrieRule.class));
        assertThat(allRules.get(0), instanceOf(AgedBrieRule.class));

    }
}

