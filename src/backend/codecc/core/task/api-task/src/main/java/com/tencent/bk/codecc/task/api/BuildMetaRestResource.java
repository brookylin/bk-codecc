/*
 * Tencent is pleased to support the open source community by making BK-CODECC 蓝鲸代码检查平台 available.
 *
 * Copyright (C) 2019 Tencent.  All rights reserved.
 *
 * BK-CODECC 蓝鲸代码检查平台 is licensed under the MIT license.
 *
 * A copy of the MIT License is included in this file.
 *
 *
 * Terms of the MIT License:
 * ---------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.tencent.bk.codecc.task.api;

import static com.tencent.devops.common.api.auth.HeaderKt.AUTH_HEADER_DEVOPS_TOOL_IMAGE_TAG;
import static com.tencent.devops.common.api.auth.HeaderKt.AUTH_HEADER_DEVOPS_USER_ID;

import com.tencent.bk.codecc.task.vo.MetadataVO;
import com.tencent.devops.common.api.ToolMetaBaseVO;
import com.tencent.devops.common.api.pojo.codecc.Result;
import com.tencent.devops.common.constant.ComConstants;
import com.tencent.devops.common.constant.ComConstants.ToolIntegratedStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * 元数据的接口类
 *
 * @version V1.0
 * @date 2019/4/19
 */
@Api(tags = {"META"}, description = "元数据查询")
@Path("/build/meta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BuildMetaRestResource {

    @ApiOperation("查询工具列表")
    @Path("/toolList")
    @GET
    Result<List<ToolMetaBaseVO>> toolList(
            @ApiParam(value = "是否查询详细信息")
            @QueryParam("isDetail")
            Boolean isDetail);

    @ApiOperation("查询元数据")
    @Path("/metadatas")
    @GET
    Result<Map<String, List<MetadataVO>>> metadatas(
            @ApiParam(value = "元数据类型", required = true)
            @QueryParam("metadataType")
            String metadataType);

    @ApiOperation("更新工具状态元数据")
    @Path("/tools/{toolName}/integratedStatus/update")
    @PUT
    Result<String> updateToolIntegratedToStatus(
            @ApiParam(value = "用户名", required = true)
            @HeaderParam(AUTH_HEADER_DEVOPS_USER_ID)
            String userName,
            @ApiParam(value = "工具镜像版本", required = false)
            @HeaderParam(AUTH_HEADER_DEVOPS_TOOL_IMAGE_TAG)
            String toolImageTag,
            @ApiParam(value = "工具名称")
            @PathParam("toolName")
            String toolName,
            @ApiParam(value = "源状态")
            @QueryParam("fromStatus")
            ToolIntegratedStatus fromStatus,
            @ApiParam(value = "目标状态")
            @QueryParam("toStatus")
            ToolIntegratedStatus toStatus
    );

    @ApiOperation("回滚工具状态元数据")
    @Path("/tools/{toolName}/integratedStatus/revert")
    @PUT
    Result<String> revertToolIntegratedStatus(
            @ApiParam(value = "用户名", required = true)
            @HeaderParam(AUTH_HEADER_DEVOPS_USER_ID)
            String userName,
            @ApiParam(value = "工具名称")
            @PathParam("toolName")
            String toolName,
            @ApiParam(value = "状态")
            @QueryParam("status")
            ToolIntegratedStatus status
    );
}
