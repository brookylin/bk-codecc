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
 * 通用告警视图
 * 
 * @date 2019/12/3
 * @version V1.0
 */
@Data
@ApiModel("通用告警视图")
public class CommonStatisticVO extends StatisticVO
{
    @ApiModelProperty("新增告警个数")
    private int newCount;

    @ApiModelProperty("遗留告警个数")
    private int existCount;

    @ApiModelProperty("修复告警个数")
    private int fixedCount;

    @ApiModelProperty("忽略告警个数")
    private int excludeCount;

    @ApiModelProperty("关闭告警个数")
    private int closeCount;

}
