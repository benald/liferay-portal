/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

/**
 * List of editable types and their compatibilities
 * with the corresponding mappeable types
 * @review
 * @see DDMStructureClassType.java for compatible types
 * @type {!object}
 */

export const COMPATIBLE_TYPES = {
	'background-image': ['ddm-image', 'image'],

	html: [
		'boolean',
		'date',
		'ddm-date',
		'ddm-decimal',
		'ddm-integer',
		'ddm-number',
		'ddm-text-html',
		'decimal',
		'geolocation',
		'integer',
		'number',
		'rich-text',
		'text',
		'textarea',
		'url',
	],

	image: ['ddm-image', 'image'],

	link: [
		'boolean',
		'date',
		'ddm-date',
		'ddm-decimal',
		'ddm-integer',
		'ddm-number',
		'ddm-text-html',
		'decimal',
		'geolocation',
		'integer',
		'number',
		'rich-text',
		'text',
		'textarea',
		'url',
	],

	'rich-text': [
		'boolean',
		'date',
		'ddm-date',
		'ddm-decimal',
		'ddm-integer',
		'ddm-number',
		'ddm-text-html',
		'decimal',
		'geolocation',
		'integer',
		'number',
		'rich-text',
		'text',
		'textarea',
		'url',
	],

	text: [
		'boolean',
		'date',
		'ddm-date',
		'ddm-decimal',
		'ddm-integer',
		'ddm-number',
		'decimal',
		'geolocation',
		'integer',
		'number',
		'text',
		'textarea',
		'url',
	],
};
