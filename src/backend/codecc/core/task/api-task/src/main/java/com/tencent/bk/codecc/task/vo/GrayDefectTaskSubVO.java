/*
 * Tencent is pleased to support the open source community by making BlueKing available.
 * Copyright (C) 2017-2018 Tencent. All rights reserved.
 * Licensed under the MIT License (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * http://opensource.org/licenses/MIT
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package com.tencent.bk.codecc.task.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 扫描出告警的任务视图
 * 
 * @date 2021/2/22
 * @version V1.0
 */
@Data
@ApiModel("扫描出告警的任务视图")
public class GrayDefectTaskSubVO {
    @ApiModelProperty("任务id")
    private Long taskId;

    @ApiModelProperty("上次告警数")
    private Integer lastDefectCount;

    @ApiModelProperty("扫描耗时")
    private Long lastElapsedTime;

    @ApiModelProperty("本次告警数")
    private Integer currentDefectCount;

    @ApiModelProperty("本次耗时")
    private Long currentElapsedTime;

    /**
     * int TASK_FLAG_SUCC = 1;  成功
     * int TASK_FLAG_FAIL = 2;  失败
     * int TASK_FLAG_PROCESSING = 3;  进行中
     */
    @ApiModelProperty("任务状态")
    private int taskState;

    @ApiModelProperty("仓库url")
    private String gitUrl;

    @ApiModelProperty("codecc链接")
    private String codeccUrl;

    @ApiModelProperty("最近分析状态")
    private String analyzeDate;
}
