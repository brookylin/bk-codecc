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
 
package com.tencent.bk.codecc.openapi.op.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 组织架构详情实体类
 * 
 * @date 2020/5/15
 * @version V1.0
 */
@Data
public class OrgDetailEntity 
{
    @Field("bg_id")
    private Integer bgId;

    @Field("dept_id")
    private Integer deptId;

    @Field("center_id")
    private Integer centerId;
}
