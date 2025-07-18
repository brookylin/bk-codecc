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

package com.tencent.bk.codecc.task.resources;

import com.tencent.bk.codecc.task.api.ServiceToolRestResource;
import com.tencent.bk.codecc.task.service.AnalyzeConfigService;
import com.tencent.bk.codecc.task.service.AnalyzeCountStatService;
import com.tencent.bk.codecc.task.service.MetaService;
import com.tencent.bk.codecc.task.service.ToolService;
import com.tencent.bk.codecc.task.vo.AnalyzeConfigInfoVO;
import com.tencent.bk.codecc.task.vo.BatchRegisterVO;
import com.tencent.bk.codecc.task.vo.ToolConfigBaseVO;
import com.tencent.bk.codecc.task.vo.ToolConfigInfoVO;
import com.tencent.bk.codecc.task.vo.ToolConfigInfoWithMetadataVO;
import com.tencent.bk.codecc.task.vo.ToolTaskInfoVO;
import com.tencent.bk.codecc.task.vo.checkerset.ClearTaskCheckerSetReqVO;
import com.tencent.bk.codecc.task.vo.checkerset.UpdateCheckerSet2TaskReqVO;
import com.tencent.bk.codecc.task.vo.pipeline.PipelineBuildInfoVO;
import com.tencent.devops.common.api.QueryTaskListReqVO;
import com.tencent.devops.common.api.pojo.codecc.Result;
import com.tencent.devops.common.constant.CommonMessageCode;
import com.tencent.devops.common.web.RestResource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 服务间调用的工具配置接口
 *
 * @version V1.0
 * @date 2019/5/7
 */
@Slf4j
@RestResource
public class ServiceToolRestResourceImpl implements ServiceToolRestResource {

    @Autowired
    private ToolService toolService;

    @Autowired
    private AnalyzeConfigService analyzeConfigService;

    @Autowired
    private MetaService metaService;

    @Autowired
    private AnalyzeCountStatService analyzeCountStatService;

    @Override
    public Result updateToolStepStatus(ToolConfigBaseVO toolConfigBaseVO) {
        toolService.updateToolStepStatus(toolConfigBaseVO);
        return new Result(CommonMessageCode.SUCCESS, "mongotemplate tool config ok");
    }


    @Override
    public Result<ToolConfigInfoVO> getToolByTaskIdAndName(long taskId, String toolName) {
        return new Result<>(toolService.getToolByTaskIdAndName(taskId, toolName));
    }

    @Override
    public Result<ToolConfigInfoWithMetadataVO> getToolWithMetadataByTaskIdAndName(long taskId, String toolName) {
        return new Result<>(toolService.getToolWithMetadataByTaskIdAndName(taskId, toolName));
    }

    @Override
    public Result<String> findToolOrder() {
        return new Result<>(metaService.getToolOrder());
    }


    @Override
    public Result<Boolean> updatePipelineTool(Long taskId, String userName, List<String> toolList) {
        return new Result<>(toolService.updatePipelineTool(taskId, toolList, userName));
    }

    @Override
    public Result<Boolean> clearCheckerSet(Long taskId, ClearTaskCheckerSetReqVO clearTaskCheckerSetReqVO) {
        return new Result<>(toolService.clearCheckerSet(taskId, clearTaskCheckerSetReqVO.getToolNames()));
    }

    @Override
    public Result<Boolean> addCheckerSet2Task(Long taskId, UpdateCheckerSet2TaskReqVO addCheckerSet2TasklReqVO) {
        return new Result<>(toolService.addCheckerSet2Task(taskId, addCheckerSet2TasklReqVO.getToolCheckerSets()));
    }

    @Override
    public Result<AnalyzeConfigInfoVO> getAnalyzeConfig(String streamName, String toolName,
            PipelineBuildInfoVO pipelineBuildInfoVO) {
        return new Result<>(analyzeConfigService.getAnalyzeConfig(streamName, toolName, pipelineBuildInfoVO));
    }

    @Override
    public Result<Boolean> updateTools(Long taskId, String user, BatchRegisterVO batchRegisterVO) {
        return toolService.updateTools(taskId, user, batchRegisterVO);
    }

    @Override
    public Result<List<ToolConfigInfoVO>> batchGetToolConfigList(QueryTaskListReqVO queryTaskListReqVO) {
        return new Result<>(toolService.batchGetToolConfigList(queryTaskListReqVO));
    }

    @Override
    public Result<Map<Integer, List<Long>>> getToolFailedTaskIds(String toolName, Set<String> createFrom,
            String detailTime) {
        return new Result<>(analyzeCountStatService.getToolFailedTaskId(toolName, createFrom, detailTime));
    }

    @Override
    public Result<ToolTaskInfoVO> getToolInfoConfigByToolName(String toolName, String detailTime) {
        return new Result<>(toolService.getToolInfoConfigByToolName(toolName, detailTime));
    }

    @Override
    public Result<List<Long>> getTaskInfoByToolNameAndTaskId(List<Long> taskIdList, String toolName) {
        return new Result<>(toolService.getTaskInfoByToolNameAndTaskId(taskIdList, toolName));
    }
}
