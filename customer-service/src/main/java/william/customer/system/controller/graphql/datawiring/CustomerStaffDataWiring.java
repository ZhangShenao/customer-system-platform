package william.customer.system.controller.graphql.datawiring;

import graphql.schema.idl.RuntimeWiring;
import william.customer.system.controller.graphql.datafetcher.AllCustomerStaffsDataFetcher;
import william.customer.system.controller.graphql.datafetcher.CustomerGroupDataFetcher;
import william.customer.system.controller.graphql.datafetcher.CustomerStaffDataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.boot.RuntimeWiringBuilderCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CustomerStaffDataWiring implements RuntimeWiringBuilderCustomizer {

    @Autowired
    private AllCustomerStaffsDataFetcher allCustomerStaffsDataFetcher;

    @Autowired
    private CustomerStaffDataFetcher customerStaffDataFetcher;

    @Autowired
    private CustomerGroupDataFetcher customerGroupDataFetcher;

    @Override
    public void customize(RuntimeWiring.Builder builder) {

        builder.type("Query", typeWiring -> typeWiring
                    .dataFetcher("staffs", allCustomerStaffsDataFetcher)
                    .dataFetcher("staff", customerStaffDataFetcher))
                .type("CustomerStaff", typeWiring -> typeWiring
                    .dataFetcher("group", customerGroupDataFetcher));
    }
}
