pipeline_template = 'java'
skip_default_checkout = true

libraries{
    maven
    approve{
        branch_conditional = "master"
    }
}