package com.fetch.feature.search.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.fetch.core.uisystem.preview.PreviewLightDark
import com.fetch.core.uisystem.theme.FetchTheme
import com.fetch.feature.search.R
import com.fetch.feature.search.uimodel.UiHiringGroup
import com.fetch.feature.search.uimodel.UiHiringItem

@Composable
fun HiringGroup(
    uiHiringGroup: UiHiringGroup,
    modifier: Modifier = Modifier
) {
    var visibility by rememberSaveable { mutableStateOf(false) }
    Card(
        modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { visibility = !visibility }
                .padding(horizontal = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 12.dp)
            ) {
                Text(
                    text = stringResource(
                        R.string.feature_search_group_name,
                        uiHiringGroup.groupId
                    ),
                    style = MaterialTheme.typography.headlineLarge,
                )
                Text(
                    text = pluralStringResource(
                        R.plurals.feature_search_group_items_count,
                        uiHiringGroup.items.size, uiHiringGroup.items.size
                    ),
                    color = MaterialTheme.colorScheme.outline
                )
            }
            Icon(
                imageVector = Icons.Rounded.ExpandMore.takeIf { visibility }
                    ?: Icons.Rounded.ExpandLess,
                stringResource(R.string.feature_search_group_name, uiHiringGroup.groupId),
                modifier = Modifier.semantics { role = Role.DropdownList })
        }
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.inverseOnSurface
        )
        AnimatedVisibility(visible = visibility) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.inverseSurface
            ) {
                Column {
                    uiHiringGroup.items.map {
                        Text(
                            it.name,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(start = 32.dp, top = 8.dp, bottom = 8.dp)
                        )

                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewHiringGroup() {
    FetchTheme {
        HiringGroup(
            uiHiringGroup = UiHiringGroup(
                groupId = 0,
                items = listOf(
                    UiHiringItem(
                        id = 0,
                        name = "Item 0"
                    ),
                    UiHiringItem(
                        id = 1,
                        name = "Item 1"
                    ),
                    UiHiringItem(
                        id = 2,
                        name = "Item 2"
                    ),
                    UiHiringItem(
                        id = 3,
                        name = "Item 3"
                    ),
                )
            )
        )
    }
}