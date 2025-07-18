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
 
package com.tencent.bk.codecc.defect.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 单个评论实体类
 * 
 * @date 2020/3/2
 * @version V1.0
 */
@Data
public class SingleCommentEntity
{
    @Field("single_comment_id")
    private String singleCommentId;

    @Field("user_name")
    private String userName;

    private String comment;

    @Field("comment_time")
    private Long commentTime;

}
