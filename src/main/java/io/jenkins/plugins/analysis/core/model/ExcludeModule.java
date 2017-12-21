package io.jenkins.plugins.analysis.core.model;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.Issues;
import edu.hm.hafner.analysis.Issues.IssueFilterBuilder;

import hudson.Extension;

/**
 * Defines a filter criteria for {@link Issues}.
 *
 * @author Ulli Hafner
 */
public class ExcludeModule extends IssuesFilter {
    /**
     * Creates a new instance of {@link ExcludeModule}.
     */
    @DataBoundConstructor
    public ExcludeModule() {
        // Required for Stapler
    }

    @Override
    public void apply(final IssueFilterBuilder builder, final String pattern) {
        builder.setExcludeModuleNameFilter(pattern);
    }

    /**
     * Dummy descriptor for {@link ExcludeModule}.
     *
     * @author Ulli Hafner
     */
   @Extension
   public static class DescriptorImpl extends IncludeFilterDescriptor {
        @Nonnull
        @Override
        public String getDisplayName() {
            return Messages.Filter_Exclude_Module();
        }
   }
}