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

package com.tencent.devops.common.auth.api.pojo.external

enum class AuthRole(val roleName: String,
                    val alias: String,
                    val codeccActions: List<CodeCCAuthAction>,
                    val pipelineActions: List<PipelineAuthAction>) {

    TASK_OWNER("manager", "拥有者",
            listOf<CodeCCAuthAction>(
                    CodeCCAuthAction.TASK_MANAGE,
                    CodeCCAuthAction.ANALYZE,
                    CodeCCAuthAction.DEFECT_MANAGE,
                    CodeCCAuthAction.DEFECT_VIEW,
                    CodeCCAuthAction.REPORT_VIEW),
                listOf<PipelineAuthAction>(
                    PipelineAuthAction.EDIT
            )
    ),
    TASK_MEMBER("member", "成员",
            listOf<CodeCCAuthAction>(
                    CodeCCAuthAction.ANALYZE,
                    CodeCCAuthAction.DEFECT_MANAGE,
                    CodeCCAuthAction.DEFECT_VIEW,
                    CodeCCAuthAction.REPORT_VIEW),
            listOf<PipelineAuthAction>(
                    PipelineAuthAction.EXECUTE
            )
    ),
    TASK_VIEWER("viewer", "查看者",
            listOf<CodeCCAuthAction>(
                    CodeCCAuthAction.DEFECT_VIEW,
                    CodeCCAuthAction.REPORT_VIEW),
            listOf<PipelineAuthAction>(
                    PipelineAuthAction.VIEW
            )
    )
}