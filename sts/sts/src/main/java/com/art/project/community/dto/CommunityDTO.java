package com.art.project.community.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommunityDTO {
	

	private int community_idx; // �Խñ۹�ȣ(PK)

	private int member_idx; // ������Թ�ȣ(FK)

	private LocalDateTime community_registDate; // �����

	private String community_title; // ����

	private String member_name; // �ۼ���(FK)

	private String community_contents; // ����

	private String community_category; // ī�װ�

	private String community_file; // ���ε�(����)

	private String community_url; // ���ε�(��ũ)

	private int community_hits; // ��ȸ��

}
