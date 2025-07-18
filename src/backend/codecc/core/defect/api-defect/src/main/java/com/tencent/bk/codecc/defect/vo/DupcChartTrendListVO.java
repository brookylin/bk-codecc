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

package com.tencent.bk.codecc.defect.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * 重复率趋势视图
 *
 * @date 2019/5/28
 */
@Data
@ApiModel("重复率趋势列表视图")
public class DupcChartTrendListVO
{

    @ApiModelProperty("重复率趋势最大值")
    private Float maxHeight;

    @ApiModelProperty("重复率趋势最小值")
    private Float minHeight;

    @ApiModelProperty("重复率趋列表势图")
    private List<DupcChartTrendVO> ducpChartList;


    public void setMaxMinHeight()
    {
        float max = 0;
        float min = 10000;

        if (CollectionUtils.isNotEmpty(ducpChartList))
        {
            for (DupcChartTrendVO aver : ducpChartList)
            {
                Float averageCCN = aver.getDupc();
                if (averageCCN > max)
                {
                    max = averageCCN;
                }
                if (averageCCN < min)
                {
                    min = averageCCN;
                }
            }
        }

        this.maxHeight = max;
        this.minHeight = min;
    }

}
