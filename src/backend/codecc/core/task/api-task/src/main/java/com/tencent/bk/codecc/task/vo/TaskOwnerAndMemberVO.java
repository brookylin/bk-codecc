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

import java.util.List;

/**
 * 任务成员及管理员视图
 * 
 * @date 2020/6/8
 * @version V1.0
 */
@Data
@ApiModel("任务成员及管理员视图")
public class TaskOwnerAndMemberVO 
{
    @ApiModelProperty("任务管理员")
    private List<String> taskOwner;

    @ApiModelProperty("任务成员")
    private List<String> taskMember;

}
