public class ${className}{
    <#list table?keys as k>
        private ${table[k].type} ${table[k].name};
        public ${table[k].type} ${table[k].getName}(){
        return ${table[k].name};
        }
        public ${table[k].type} ${table[k].setName}(${table[k].type} ${table[k].name}){
        this.${table[k].name}=${table[k].name};
        }
    </#list>

}