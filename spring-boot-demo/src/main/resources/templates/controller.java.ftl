package ${package.Controller};


import com.example.demo.common.ResultEntity;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Api(tags = "${table.comment!}")
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    ${table.serviceName} ${table.serviceName?uncap_first};

    @ApiOperation(value = "查询列表", httpMethod = "POST")
    @PostMapping("/query")
    public ResultEntity<Page<${entity}>> query(@RequestBody Page<${entity}> page) {
        Page<${entity}> ${entity?uncap_first}Page = ${table.serviceName?uncap_first}.listPage(page);
        return ResultEntity.ok(${entity?uncap_first}Page);
    }

    @ApiOperation(value = "创建", httpMethod = "POST")
    @PostMapping("")
    public ResultEntity<${entity}> create(@RequestBody @Valid ${entity} ${entity?uncap_first}) {
        ${table.serviceName?uncap_first}.create(${entity?uncap_first});
        return ResultEntity.ok(${entity?uncap_first});
    }

    @ApiOperation(value = "获取", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public ResultEntity<${entity}> get(@PathVariable Long id) {
        return ResultEntity.ok(${table.serviceName?uncap_first}.getById(id));
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping(value = "/{id}")
    public ResultEntity<String> update(@PathVariable Long id, @RequestBody @Valid ${entity} ${entity?uncap_first}) {
        ${entity?uncap_first}.setId(id);
        ${table.serviceName?uncap_first}.update(${entity?uncap_first});
        return ResultEntity.ok();
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping(value = "/{id}")
    public ResultEntity<String> remove(@PathVariable Long id) {
        ${table.serviceName?uncap_first}.removeById(id);
        return ResultEntity.ok();
    }

}
</#if>
