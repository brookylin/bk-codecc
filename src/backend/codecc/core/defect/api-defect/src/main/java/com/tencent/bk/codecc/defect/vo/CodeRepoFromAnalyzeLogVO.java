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

package com.tencent.bk.codecc.defect.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 代码库视图
 *
 * @version V1.0
 * @date 2020/2/26
 */
@Data
@ApiModel("代码库视图")
public class CodeRepoFromAnalyzeLogVO {
    /**
     * 任务ID
     */
    @ApiModelProperty("任务id")
    private long taskId;

    /**
     * 代码仓库地址
     */
    @ApiModelProperty("代码仓库地址")
    private String url;

    /**
     * 分支名
     */
    @ApiModelProperty("分支名")
    private String branch;

    /**
     * 代码仓库首次扫描时间
     */
    @ApiModelProperty("代码仓库首次扫描时间")
    private Long urlFirstScan;

    /**
     * 分支首次扫描时间
     */
    @ApiModelProperty("分支首次扫描时间")
    private Long branchFirstScan;

    /**
     * 分支首次扫描时间
     */
    @ApiModelProperty("分支最近扫描时间")
    private Long branchLastScan;

}
