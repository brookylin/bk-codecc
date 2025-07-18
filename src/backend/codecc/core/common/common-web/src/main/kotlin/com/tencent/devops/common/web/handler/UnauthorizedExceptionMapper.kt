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

package com.tencent.devops.common.web.handler

import com.tencent.devops.common.api.exception.UnauthorizedException
import com.tencent.devops.common.api.pojo.codecc.Result
import com.tencent.devops.common.constant.CommonMessageCode
import com.tencent.devops.common.service.Profile
import com.tencent.devops.common.service.utils.I18NUtils
import com.tencent.devops.common.service.utils.SpringContextUtil
import org.slf4j.LoggerFactory
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

/**
 * Created by liangyuzhou on 2017/9/23.
 * Powered By Tencent
 */
@Provider
class UnauthorizedExceptionMapper : ExceptionMapper<UnauthorizedException> {
    companion object {
        val logger = LoggerFactory.getLogger(UnauthorizedExceptionMapper::class.java)!!
    }

    override fun toResponse(exception: UnauthorizedException): Response {
        logger.error("未授权错误:", exception)
        val status = Response.Status.FORBIDDEN
        val message = if (SpringContextUtil.getBean(Profile::class.java).isDebug()) {
            exception.message
        } else {
            I18NUtils.getMessage(CommonMessageCode.UNAUTHORIZED_ACCESS_TO_RESOURCES)
        }

        return Response.status(status)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(
                    Result<Void>(
                        status = status.statusCode,
                        errCode = CommonMessageCode.UNAUTHORIZED_ACCESS_TO_RESOURCES,
                        message = message
                    )
                )
                .build()
    }
}